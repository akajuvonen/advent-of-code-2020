(ns advent-of-code.day06-test
  (:require [clojure.test :refer [deftest is testing]]
            [advent-of-code.day06]))

(deftest test-uniq-count
  (testing "uniq-count"
    (is (= 5 (advent-of-code.day06/uniq-count ["abc" "cde"])))))

(deftest test-calc-common-chars
  (testing "common-chars"
    (is (= #{\c} (advent-of-code.day06/common-chars ["abc" "cde"])))))
