(ns clojure-in-10-mins.test.stm
  (:use [clojure-in-10-mins.stm] :reload-all)
  (:use [clojure.test]))

(deftest post-test
  (testing "Can post to account."
    (is (= [{:amount 10, :msg "foo"}]
	     (post [] 10 "foo")) "Post to empty account.")
    (is (= [{:amount 10, :msg "foo"}, {:amount 20, :msg "bar"}]
	     (post [{:amount 10, :msg "foo"}] 20 "bar")))))

(deftest balance-test
  (testing "Calculation of account balance."
    (is (= 0 (balance [])) "Balance of empty account should be 0.")
    (is (= 30 (balance [{:amount 10, :msg "foo"}
			{:amount 20, :msg "bar"}]))
	"Balance should be the sum of the posted amounts.")))

(deftest transfer-test
  (testing "Transfer between accounts."
    (let [a (ref [])
	  b (ref [])]
      (transfer a b 10 "test")
      (is (= [{:amount -10, :msg "test"}] @a) "Money should be deducted from a")
      (is (= [{:amount 10, :msg "test"}] @b) "Money should be added to b"))))




