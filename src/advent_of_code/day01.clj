(ns advent-of-code.day01
  (:use [clojure.math.combinatorics :only (combinations)]))

(def wanted-sum 2020)

(defn parse
  [string]
  (clojure.string/split string #"\n"))

(defn str->int
  [strs]
  (map #(Integer. %) strs))

(defn find-multiple
  "Find the product of n entries that sum up to a target sum"
  [entries target n]
  (let [combs (clojure.math.combinatorics/combinations (vec entries) n)]
  (loop [[comb & remaining] combs]
    (if-not (empty? remaining)
      (let [product (reduce * comb)
            remainder (- target product)]
        (if (contains? entries remainder)
          (* product remainder)
          (recur remaining)))))))

(defn part1
  [input]
  (let [entries-set (set (str->int (parse input)))]
    (find-multiple entries-set wanted-sum 1)))

(defn part2
  [input]
  (let [entries-set (set (str->int (parse input)))]
    (find-multiple entries-set wanted-sum 2)))