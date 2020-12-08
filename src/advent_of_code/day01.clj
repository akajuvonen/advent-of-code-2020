(ns advent-of-code.day01
  (:require [clojure.string :as str])
  (:use [clojure.math.combinatorics :only (combinations)]))

(defn parse [string]
  (str/split string #"\n"))

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
  (parse input))
