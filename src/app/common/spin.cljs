(ns app.common.spin)

(defn spinner
  ([show]
   (spinner "" show))
  ([color show]
   (when (true? show)
     (let [c (if (seq color)
               color
               "#000000")]
       [:div {:style {:color c} ;;"#79bbb5"}
              :class "la-ball-spin-fade-rotating la-2x z-999"}
        [:div] [:div] [:div] [:div] [:div] [:div] [:div] [:div]]))))
