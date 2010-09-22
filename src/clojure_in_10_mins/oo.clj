(ns clojure-in-10-mins.oo)

;; Object Oriented (sort of)

(defprotocol Price
  (price [x]))
(defprotocol Vat
  (vat [x]))

(defn price-with-vat [x]
  (+ (price x) (vat x)))

(defn standard-vat [x]
  (* (/ 25 100) (price x)))

(defrecord menu-item [name price])
(def espresso (menu-item. "Espresso" 12))
(def cortado (menu-item. "Cortado" 16))

(extend-type menu-item
  Price
  (price [x] (:price x))
  Vat
  (vat [x] (standard-vat x)))

(defrecord stamp [series name value])
(def iver (stamp.
	   "Royal Danish Navy 500th Anniversary"
	   "Iver Huitfeldt" 5.50))

(extend-type stamp
  Price
  (price [s] (:value s))
  Vat
  (vat [s] 0))

(comment
  (vat cortado)
  (price-with-vat espresso)

  (vat iver)
  (price-with-vat iver)
  )
