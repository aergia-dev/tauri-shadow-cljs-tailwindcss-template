(ns app.core
  (:require [reagent.dom :as r.dom]
            [reagent.core :as r]
            ["react-dom/client" :refer [createRoot]]
            [re-frame.core :as rf :refer [dispatch dispatch-sync]]
            [app.views :as v]
            [app.events]
            [app.subs]
            [app.db]
            [cognitect.transit :as transit]))

(dispatch-sync [:init-db])

(defonce root (createRoot (js/document.getElementById "app")))

(defn render []
  (.render root (r/as-element [v/views])))

(defn ^:export init []
  (render))

(defn ^:dev/after-load clear-cache-and-render!
  []
  ;; The `:dev/after-load` metadata causes this function to be called
  ;; after shadow-cljs hot-reloads code. We force a UI update by clearing
  ;; the Reframe subscription cache.
  (rf/clear-subscription-cache!)

  (render))
