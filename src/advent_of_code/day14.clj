(ns advent-of-code.day14)

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

(Integer/toBinaryString 11)
(Integer/parseInt "1011" 2)

(let [s "1011"]
  (pad-binary-string s 36))

(let [number "1011"
      mask "X1XX"]
  (apply-bitmask number mask))
