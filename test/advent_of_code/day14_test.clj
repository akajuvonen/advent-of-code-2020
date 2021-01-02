(ns advent-of-code.day14-test
  (:require [clojure.test :refer [deftest is testing]]
            [advent-of-code.day14]))

(deftest test-apply-bitmask
  (testing "apply-bitmask"
    (is (= "1101"
           (advent-of-code.day14/apply-bitmask "1011" "X10X")))))
