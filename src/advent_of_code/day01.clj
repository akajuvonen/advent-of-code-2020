(ns advent-of-code.day01
  (:use [clojure.math.combinatorics :only (combinations)]))

(defn parse [string]
  (clojure.string/split string #"\n"))

(defn str->int
  [strs]
  (map #(Integer. %) strs))

(defn find-multiple
  "Find the multiple of two entries that sum up to 2020"
  [entries]
  (loop [[entry & remaining] entries]
    (if-not (empty? remaining)
      (let [remainder (- 2020 entry)]
        (if (contains? entries remainder)
          (* entry remainder)
          (recur remaining))))))

(defn part1
  [input]
  (let [entries-set (set (str->int (parse input)))]
    (find-multiple entries-set)))
