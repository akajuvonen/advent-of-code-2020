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

(let [[timestamp bus-ids] (parse test-input)]
  (map #(mod timestamp %) bus-ids))
