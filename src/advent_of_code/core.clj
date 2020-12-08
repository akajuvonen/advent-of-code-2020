(ns advent-of-code.core
  (:use [clojure.math.combinatorics :only (combinations)]))

(defn parse [string]
  (clojure.string/split (string) #"\n"))
  

(defn day1-part1
  "Find the multiple of two entries that sum up to 2020"
  [entries]
  (loop [[entry & remaining] entries]
    (if-not (empty? remaining)
      (let [remainder (- 2020 entry)]
        (if (contains? entries remainder)
          (* entry remainder)
          (recur remaining))))))

(defn -main
  "Advent of code solutions main."
  [& args]
  (parse (slurp "inputs/day1.txt")))
