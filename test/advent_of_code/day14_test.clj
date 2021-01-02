(ns advent-of-code.day14-test
  (:require [clojure.test :refer [deftest is testing]]
            [advent-of-code.day14]))

(deftest test-pad-binary-string
  (testing "pad-binary-string"
    (is (= "00001011"
           (advent-of-code.day14/pad-binary-string "1011" 8)))))

(deftest test-apply-bitmask
  (testing "apply-bitmask"
    (is (= "1101"
           (advent-of-code.day14/apply-bitmask "1011" "X10X")))))
