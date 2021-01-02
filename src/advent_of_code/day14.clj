(ns advent-of-code.day14)

(defn pad-binary-string
  "Pad a binary string with leading zeros to specified length."
  [string length]
  (let [padding-size (- length (count string))
        padding (apply str (take padding-size (repeat "0")))]
    (str padding string)))

(Integer/toBinaryString 11)
(Integer/parseInt "1011" 2)

(let [s "1011"]
  (pad-binary-string s 36))


