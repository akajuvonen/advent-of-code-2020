(ns advent-of-code.day15-test
  (:require [clojure.test :refer [deftest is testing]]
            [advent-of-code.day25 :refer [get-loops]]))

(deftest test-get-loops
  (testing "get-loops"
    (is (= (get-loops 5764801) 8))
    (is (= (get-loops 17807724) 11))))

