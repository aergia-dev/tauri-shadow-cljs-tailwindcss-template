(ns app.core
  (:require [reagent.dom :as r.dom]
            [re-frame.core :as rf :refer [dispatch dispatch-sync]]
            [app.views :as view]
            [app.db]
            [app.subs]
            [app.events]
            [cognitect.transit :as transit]))

(dispatch-sync [:init-db])  

(defn render []
  (r.dom/render [view/default-view]
                (js/document.getElementById "app")))

(defn ^:export init []
  (render))


(defn ^:dev/after-load clear-cache-and-render!
  []
  ;; The `:dev/after-load` metadata causes this function to be called
  ;; after shadow-cljs hot-reloads code. We force a UI update by clearing
  ;; the Reframe subscription cache.
  (rf/clear-subscription-cache!)

  (render))
