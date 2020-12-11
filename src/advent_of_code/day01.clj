(ns advent-of-code.day01
  (:require [clojure.math.combinatorics]
            [clojure.string]))

(def wanted-sum 2020)

(defn parse
  [string]
  (clojure.string/split string #"\n"))

(defn str->int
  [strs]
  (map #(Integer. %) strs))

(defn find-product
  "Find the product of n entries that sum up to a target sum"
  [entries target n]
  (let [combs (clojure.math.combinatorics/combinations (vec entries) n)]
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
  (let [entries-set (set (str->int (parse input)))]
    (find-product entries-set wanted-sum 1)))

(defn part2
  [input]
  (let [entries-set (set (str->int (parse input)))]
    (find-product entries-set wanted-sum 2)))