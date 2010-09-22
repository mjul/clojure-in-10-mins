(ns clojure-in-10-mins.stm)

;; STM - software transactional memory

(defn post [account amount msg]
  (conj account {:amount amount, :msg msg}))

(defn transfer [from to amount msg]
  (dosync
   (alter from post (- amount) msg)
   (alter to post amount msg)))

(defn balance [account]
  (reduce + 0 (map :amount account)))

;; For demo
(comment 
  (def account-a (ref [{:amount 100, :msg "Initial"}]))
  (def account-b (ref []))
  (transfer account-a account-b 50 "Tickets")
  (balance @account-a)
  (balance @account-b)
)





