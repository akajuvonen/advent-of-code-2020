(ns advent-of-code.day05
  (:require [clojure.string :as str]))

(defn binary-space-partition
  "Find a number by dividing the range into lower and upper half
   until only one number remains."
  [lower
   upper
   s
   lower-char]
  (if (nil? s)
    upper
    (let [[c & remaining] s
          diff (/ (- upper (dec lower)) 2)]
      (if (= c lower-char)
        (recur lower (- upper diff) remaining lower-char)
        (recur (+ lower diff) upper  remaining lower-char)))))

(defn get-seat-id
  "Calculate seat ID from a string (row * 8 + column)."
  [s]
  (let [row-string (subs s 0 7)
        column-string (subs s 7 10)
        row (dec (binary-space-partition 1 128 row-string \F))
        column (dec (binary-space-partition 1 8 column-string \L))]
    (+ (* 8 row) column)))

(defn part1
  [input]
  (as-> input $
    (slurp $)
    (str/split $ #"\n")
    (map get-seat-id $)
    (apply max $)))
