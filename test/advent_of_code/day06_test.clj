(ns advent-of-code.day06-test
  (:require [clojure.test :refer [deftest is testing]]
            [advent-of-code.day06]))

(deftest calculate-seat-id
  (testing "uniq-count"
    (is (= 5 (advent-of-code.day06/uniq-count ["abc" "cde"])))))