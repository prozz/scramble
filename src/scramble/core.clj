(ns scramble.core)

(defn scramble? [s1 s2]
  (let [alphabet (zipmap (seq "abcdefghijklmnopqrstuvwxyz") (repeat 0))
        allowed-count (merge-with + alphabet (frequencies s1))]
    (every? (complement neg?)
            (vals (merge-with - allowed-count (frequencies s2))))))

