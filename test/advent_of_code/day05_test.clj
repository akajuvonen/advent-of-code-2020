(ns advent-of-code.day05-test
  (:require [clojure.test :refer [deftest is testing]]
            [advent-of-code.day05]))

(deftest calculate-seat-id
  (testing "get-seat-id"
    (is (= 357 (advent-of-code.day05/get-seat-id "FBFBBFFRLR")))))