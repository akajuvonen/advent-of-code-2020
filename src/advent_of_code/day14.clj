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

(defn- parse-mask
  [line]
  (second (str/split line #"mask = ")))

(defn- parse-mem-value
  [line]
  line)

(defn process
  [lines]
  lines)

(defn part1
  [input]
  (-> input
      slurp
      str/split-lines
      process))

(comment
  (Integer/toBinaryString 39993)
  (Integer/parseInt "1011" 2)
  (let [s "1001110000111001"]
    (pad-binary-string s 36))
  (let [number "1011"
        mask "X1XX"]
    (apply-bitmask number mask))
  (parse-mask "mask = 01X1101100X00X10X00110111X0011111X10")
  (parse-mem-value "mem [40640] = 198926"))
