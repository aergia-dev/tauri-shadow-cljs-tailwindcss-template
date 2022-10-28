(ns app.views
  (:require [reagent.core :as r]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [app.subs]
            [app.toaster :as toaster]
            ["react-toastify" :refer [ToastContainer]]
            ["@tauri-apps/api/dialog" :as dialog]
            [""]
            [taoensso.timbre :refer [debug info error fatal]]))

(defn ui-src-file []
     [:button {:class "bg-blue-500 hover:bg-blue-800 text-white font-bold rounded-full px-4 py-2"
               :on-click (fn [e]
                           (let [f (.open dialog (clj->js {:multiple true}))]
                             (-> f
                                 (.then #(dispatch [:files %]))
                                 (.catch #(js/alert "file open err: %")))))} "open"])

(defn ui-dest []
  [:div "dst"]
  )

(defn ui-pred []
  [:div "pred"]
  )

(defn default-view []
  [:div
   [:> ToastContainer (clj->js {:position "top-right"
                                :autoClose 2000
                                :hideProgressBar false
                                :newestOnTop true
                                :rtl false
                                :pauseOnFocusLoss false
                                :draggable true
                                :pauseOnHover true})]
   [:div (ui-src-file)]
   ;; [:div (ui-dest)]
   ;; [:div (ui-pred)]
   ]
  )


