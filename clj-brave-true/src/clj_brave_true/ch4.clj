(ns clj-brave-true.ch4)

;;;;;;;;;;;;;;;;;;;;
;; Task 1
;;;;;;;;;;;;;;;;;;;;

(def names '(["Edward Cullen" "10"], ["Bella Swan" "0"], ["Charlie Swan" "0"],
                                     ["Jacob Black" "3"], ["Carlisle Cullen" "6"]))

(def vamp-keys [:name :glitter-index])

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn mapify
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(defn glitter-filter
  "Return a list of names that pass the glitter-filter"
  [minimum-glitter records]
  (map #(:name %)
   (filter (fn [vamp]
            (if (>= (:glitter-index vamp) minimum-glitter)
              (:name vamp)))
           records)))
