(ns advent-of-code.day18
  (:require [clojure.walk :as walk]
            [clojure.string :as str]))

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

(defn traverse
  "Traverse a tree (list of lists) in post-order and apply f."
  [tree f]
  (walk/postwalk f tree))

(defn part1
  [input]
  (as-> input i
    (slurp i)
    (str/split-lines i)
    (map #(str \( % \)) i)
    (map read-string i)
    (map #(traverse % evaluate) i)
    (reduce + i)))

(part1 "inputs/day18.txt")
