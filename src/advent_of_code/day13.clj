(ns advent-of-code.day13
  (:require [clojure.string :as str]))

(defn parse
  "Parse input string and return
   [timestamp (list of bus ids) (list of indices if each id on the departure list)].
   Note that indices are calculated before buses not in service (marked with x) are
   removed."
  [input]
  (let [split-input (str/split-lines input)
        timestamp (Integer. (first split-input))
        bus-id-strings (str/split (second split-input) #",")
        bus-ids-enumerated (map vector (range) bus-id-strings)
        bus-ids-filtered (filter #(not= "x" (second %)) bus-ids-enumerated)
        bus-ids (map #(Integer. (second %)) bus-ids-filtered)
        indices (map first bus-ids-filtered)]
    [timestamp bus-ids indices]))

(defn departure-by-id
  "Calculate time to next departure for a bus id."
  [timestamp id]
  (- id (mod timestamp id)))

(defn all-departures-by-id
  "Calculate pairs containing id and time to that id's next departure."
  [timestamp ids]
  (let [departures (map #(departure-by-id timestamp %) ids)]
    (map vector ids departures)))

(defn find-modulo
  "Finds a number starting from `start` taking steps of size `stepsize` so that
   (number + `offset` mod `modulo`) == 0."
  [start stepsize modulo offset]
  (loop [x start]
    (if (= (mod (+ x offset) modulo) 0)
      x
      (recur (+ x stepsize)))))

(defn find-subsequent-departures
  "Find departures leaving at certain offsets (designated by their indices).
   The solution uses Chinese Remainder Theorem with sieving method. Check
   AoC day 13 part 2 description for more details."
  [ids indices]
  (loop [x (first ids)
         stepsize (first ids)
         modulo (second ids)
         offset (second indices)
         ids-remaining (rest ids)
         indices-remaining (rest indices)]
    (if (nil? modulo)
      x
      (recur (find-modulo x stepsize modulo offset)
             (* stepsize (first ids-remaining))
             (second ids-remaining)
             (second indices-remaining)
             (rest ids-remaining)
             (rest indices-remaining)))))

(defn part1
  [input-filename]
  (let [[timestamp bus-ids _] (parse (slurp input-filename))
        departures-by-id (all-departures-by-id timestamp bus-ids)]
    (reduce * (apply min-key second departures-by-id))))

(defn part2
  [input-filename]
  (let [[_ ids indices] (parse (slurp input-filename))]
    (find-subsequent-departures ids indices)))
