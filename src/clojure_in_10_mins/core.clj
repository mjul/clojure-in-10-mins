(ns clojure-in-10-mins.core)

(println "Hello, World")

; This is a comment, semicolon is similar to // in C# / Java

;; Clojure has almost no syntax
;; Just a few data types

;; List is the most common data structure
(1 2 3)

;; Vector is a list that is indexable by position
[1 2 3]

;; Maps are associative data structures
{:key "value", :id 42}

;; Sets are mathematical sets
#{1 2 3}

;; Expressions are list of the form (function arg-1 arg-2 ...)
(+ 1 2 3)

;; ----------------------------------------------------------------

;; Persistent data structures

(def a (list 1 2 3))
(def b (rest a))


;; ----------------------------------------------------------------
;; Functional programming

(def answer 42)

(defn factorial [n]
  (if (< 1 n)
    (* n (factorial (dec n)))
    1))

(defn factorial2 [n]
  (reduce * (range 1 (inc n))))


;; ----------------------------------------------------------------
;; STM - software transactional memory

(def account-a (ref [{:amount 100, :msg "Initial"}]))
(def account-b (ref []))

(defn post [account amount msg]
  (conj account {:amount amount, :msg msg}))

(defn transfer [from to amount msg]
  (dosync
   (alter from post (- amount) msg)
   (alter to post amount msg)))

(defn balance [account]
  (reduce + 0 (map :amount account)))

(map balance [@account-a @account-b]) 
(transfer account-a account-b 100 "Tickets")
(map balance [@account-a @account-b]) 









