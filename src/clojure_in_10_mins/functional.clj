(ns clojure-in-10-mins.functional)

;; Functional programming
(def answer 42)

(defn double [x]
  (* 2 x))

(defn max [a b]
  (if (< a b) b a))

(defn factorial [x]
  (reduce * 1 (range 1 (inc x))))


;; List comprehension
(for [x (range 3)]
  (str "Element " x))


(def my-list (list 1 2 3))
(def my-vec [10 20 30])
(def my-map {:clojure "Rich", :perl "Larry", :python "Guido", :ruby "Matz"})
(def my-set #{:a :b :c})

;; Seq operations
(first my-list)
(rest my-vec)
(conj my-list "a" "b" "c")
(cons "CAR" my-list)

;; Higher-order functions
(map double my-vec)
(reduce + 0 my-list)
(filter even? my-list)
(remove even? my-list)
(sort-by :name [{:id 1, :name "Anders"} {:id 2, :name "Bjarne"}])

;; Map operations
(keys my-map)
(vals my-map)
(assoc my-map :c++ "Bjarne")













