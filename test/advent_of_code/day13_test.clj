(ns advent-of-code.day13-test
  (:require [clojure.test :refer [deftest is testing]]
            [advent-of-code.day13]))

(deftest test-find-subsequent-departures
  (testing "find-subsequent-departures"
    (is (= 1068781 (advent-of-code.day13/find-subsequent-departures
                    '(7 13 59 31 19) '(0 1 4 6 7))))))
