(ns advent-of-code.day15
  (:require [clojure.string :as str]))

(defn- init-numbers-map
  [initial-numbers]
  (into {}
        (map vector initial-numbers (range 1 (inc (count initial-numbers))))))

(defn memory-game
  [initial-numbers n]
  (loop [numbers (init-numbers-map initial-numbers)
         turn (count initial-numbers)
         last-number (last initial-numbers)]
    (if (>= turn n)
      last-number
      (if-let [last-spoken (get numbers last-number)]
        (let [turns-apart (- turn last-spoken)]
          (recur (assoc numbers last-number turn)
                 (inc turn)
                 turns-apart))
        (recur (assoc numbers last-number turn)
               (inc turn)
               0)))))

(defn parse
  [input]
  (let [strings (-> input slurp (str/split #","))]
    (map #(Integer. %) strings)))

(defn part1
  [input]
  (-> input
      parse
      (memory-game 2020)))
