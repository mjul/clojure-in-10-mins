(ns clojure-in-10-mins.multi)

;; Object Oriented - multimethods

(defrecord menu-item [name type price])
(def espresso (menu-item. "Espresso" :drink 12))
(def cortado (menu-item. "Cortado" :drink 16))
(def burger (menu-item. "Burger Royale" :food 100))

(defmulti type-info class)
(defmethod type-info String [x] (str "It is a String: " x))
(defmethod type-info menu-item [x] (str "It is a menu item!"))
(defmethod type-info :default [x] (str "It is a " (class x)))

(comment
  (type-info "Hello, World!")
  (type-info 42)
  (type-info espresso)
)

(defmulti description :type)
(defmethod description :drink [x]  (str "Drink a wonderful " (:name x)))
(defmethod description :food [x]   (str "Savour a tasty " (:name x)))


