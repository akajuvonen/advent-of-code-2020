(ns advent-of-code.day15-test
  (:require [clojure.test :refer [deftest is testing]]
            [advent-of-code.day25 :refer [get-loops get-key]]))

(deftest test-get-loops
  (testing "get-loops"
    (is (= (get-loops 5764801) 8))
    (is (= (get-loops 17807724) 11))))

(deftest test-get-key
  (testing "get-key"
    (is (= (get-key 17807724 8) 14897079)
        (= (get-key 5764801 11) 14897079))))
