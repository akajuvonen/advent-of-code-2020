(ns advent-of-code.day13
  (:require [clojure.string :as str]))

(def test-input "939\n7,13,x,x,59,x,31,19")

(defn parse
  [input]
  (let [split-input (str/split-lines input)
        timestamp (Integer. (first split-input))
        bus-id-strings (str/split (second split-input) #",")
        bus-id-filtered (filter #(not= "x" %) bus-id-strings)
        bus-ids (map #(Integer. %) bus-id-filtered)]
    [timestamp bus-ids]))

(defn departures-by-id
  "Calculate pairs containing id and time to that id's next departure."
  [timestamp ids]
  (let [departures (map #(- % (mod timestamp %)) ids)]
    (map vector ids departures)))

(let [[timestamp bus-ids] (parse test-input)]
  (departures-by-id timestamp bus-ids))

