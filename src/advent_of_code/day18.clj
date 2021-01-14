(ns advent-of-code.day18
  (:require [clojure.walk :as walk]))

(defn- infix
  [left [op right]]
  ((resolve op) left right))

(defn evaluate
  "Evaluate a list containing arithmetic expressions, e.g.,
   `(1 + 2 * 3)`. If input is not a list, return identity."
  [x]
  (if (list? x)
    (let [[acc & remaining] x]
      (reduce infix acc (partition 2 remaining)))
    x))

(evaluate (read-string "(1 + 2 * 3)"))

(defn part1
  [input]
  (slurp input))