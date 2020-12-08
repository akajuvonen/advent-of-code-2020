(ns advent-of-code.day01
  (:use [clojure.math.combinatorics :only (combinations)]))

(def wanted-sum 2020)

(defn parse [string]
  (clojure.string/split string #"\n"))

(defn str->int
  [strs]
  (map #(Integer. %) strs))

(defn find-multiple
  "Find the multiple of two entries that sum up to a wanted sum"
  [entries target]
  (loop [[entry & remaining] entries]
    (if-not (empty? remaining)
      (let [remainder (- target entry)]
        (if (contains? entries remainder)
          (* entry remainder)
          (recur remaining))))))

(defn part1
  [input]
  (let [entries-set (set (str->int (parse input)))]
    (find-multiple entries-set wanted-sum)))
