(ns advent-of-code.day14
  (:require [clojure.string :as str]))

(defn pad-binary-string
  "Pad a binary string with leading zeros to specified length."
  [string length]
  (let [padding-size (- length (count string))
        padding (apply str (take padding-size (repeat "0")))]
    (str padding string)))

(defn- mask-bit
  "Apply a bit mask to one bit. `X` means return original bit, otherwise mask."
  [bit mask]
  (if (= mask \X)
    bit
    mask))

(defn apply-bitmask
  "Apply a bitmask to a binary string. `X` means that the bit is unchanged,
   otherwise changed to the corresponding value in mask. E.g.,
   number = 1011, mask = X1XX -> 1111"
  [number mask]
  (apply str (map mask-bit number mask)))

(defn apply-mask-int
  [number mask length]
  (-> number
    (Integer/toBinaryString)
    (pad-binary-string length)
    (apply-bitmask mask)
    (Long/parseLong 2))) ; can only decode 32-bit integers, not 36

(defn- parse-mask
  [line]
  (second (str/split line #"mask = ")))

(defn- parse-mem-value
  [line]
  (->> line
       (re-matches #"mem\[(\d+)\]\ =\ (\d+)")
       (drop 1)
       (map #(Integer/parseInt %))))

(defn process
  [lines]
  (loop [[current-line & remaining-lines] lines
         mask "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
         memory {}]
    (if (empty? current-line)
      memory
      (if-let [new-mask (parse-mask current-line)]
        (recur remaining-lines
               new-mask
               memory)
        (let [[address value] (parse-mem-value current-line)
              masked-value (apply-mask-int value mask 36)]
          (recur remaining-lines
                 mask
                 (assoc memory address masked-value)))))))

(defn part1
  [input]
  (->> input
      slurp
      str/split-lines
      process
      vals
      (reduce +)))
