(ns advent-of-code.day01
  (:require [clojure.math.combinatorics :as combinatorics]
            [clojure.string :as str]))

(def wanted-sum 2020)

(defn str->int
  [strs]
  (map #(Integer. %) strs))

(defn find-product
  "Find the product of n entries that sum up to a target sum"
  [entries target n]
  (let [combs (combinatorics/combinations (vec entries) n)]
  (loop [[comb & remaining] combs]
    (if-not (empty? remaining)
      (let [sum (reduce + comb)
            remainder (- target sum)]
        (if (contains? entries remainder)
          (reduce * (conj (vec comb) remainder))
          (recur remaining)))
      nil))))

(defn part1
  [input]
  (let [entries-set (set (str->int (str/split-lines (slurp input))))]
    (find-product entries-set wanted-sum 1)))

(defn part2
  [input]
  (let [entries-set (set (str->int (str/split-lines (slurp input))))]
    (find-product entries-set wanted-sum 2)))
