(ns advent-of-code.day02)

(defn validate-passwd
  "Validate that character count in passwd is in range [lowest, highest]"
  [lowest 
   highest 
   character
   passwd]
  (<= lowest (get (frequencies passwd) character) highest))
