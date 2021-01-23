(ns advent-of-code.day25
  (:require [clojure.string :as str]))

(defn transform
  [value]
  (rem  (* value 7) 20201227))

(transform 100000000)