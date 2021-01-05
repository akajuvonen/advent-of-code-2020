(ns advent-of-code.day15-test
  (:require [clojure.test :refer [deftest is testing]]
            [advent-of-code.day15 :refer [memory-game]]))

(deftest test-memory-game
  (testing "memory-hame"
    (is (= 436 (memory-game '(0 3 6) 2020)))
    (is (= 1 (memory-game '(1 3 2) 2020)))
    (is (= 10 (memory-game '(2 1 3) 2020)))
    (is (= 27 (memory-game '(1 2 3) 2020)))
    (is (= 78 (memory-game '(2 3 1) 2020)))
    (is (= 438 (memory-game '(3 2 1) 2020)))
    (is (= 1836 (memory-game '(3 1 2) 2020)))))

