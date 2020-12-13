(ns advent-of-code.day02-test
  (:require [clojure.test :refer [deftest is testing]]
            [advent-of-code.day02]))

(deftest valide-passwd-count-test
  (testing "validate-passwd-count"
    (is (advent-of-code.day02/validate-passwd-count 1 2 \a "abc"))
    (is (false? (advent-of-code.day02/validate-passwd-count 1 2 \a "aaa")))))

(deftest valide-passwd-index-test
  (testing "validate-passwd-index"
    (is (advent-of-code.day02/validate-passwd-index 1 2 \a "abc"))
    (is (false? (advent-of-code.day02/validate-passwd-index 1 2 \a "aac")))))
