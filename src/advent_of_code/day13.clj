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
   (number mod `modulo`) == `remainder`."
  [start stepsize modulo remainder]
  (println [start stepsize modulo remainder])
  (loop [x start]
    (if (= (mod x modulo) remainder)
      x
      (recur (+ x stepsize)))))

(defn find-subsequent-departures
  [ids indices]
  (let [ids-indices (map vector ids indices)]
    (println ids-indices)
    (loop [[f s & remaining] ids-indices
           stepsize (first f)
           x (first f)]
      (if (nil? s)
        x
        (recur (cons s remaining)
               (* stepsize (first s))
               (find-modulo x stepsize (first s) (- (first s) (second s))))))))

(defn part1
  [input-filename]
  (let [[timestamp bus-ids _] (parse (slurp input-filename))
        departures-by-id (all-departures-by-id timestamp bus-ids)]
    (reduce * (apply min-key second departures-by-id))))

(defn part2
  [input-filename]
  (let [[_ ids indices] (parse (slurp input-filename))]
    (find-subsequent-departures ids indices)))

(time (part2 "inputs/day13.txt"))

(def test-input "1\n1789,37,47,1889")
(let [[_ ids indices] (parse test-input)]
  (find-subsequent-departures ids indices))
