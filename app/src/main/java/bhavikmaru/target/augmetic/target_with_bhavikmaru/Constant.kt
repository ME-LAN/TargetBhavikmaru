package com.inexture.gujaratelection.utils

import android.content.Context
import android.util.TypedValue

/**
 * Created by Inexture on 10/31/2017.
 */

fun Context.dpToPx(dp: Float) =
        (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, this.resources.displayMetrics)).toInt()

object Constants {

    val EXTRA_BURNING_CONS_ID = "burning_cons_id"
    val EXTRA_OPINION_CONS_ID = "opinion_cons_id"

    val PREF_IS_ENGLISH = "is_english"

    val EXTRA_OP_CONS_ID = "oid"

    val NEWS_ID = "id"
    val EXTRA_NEWS = "news"
    val PREF_USER_DEVICE_ID = "pref_user_device_id"
    val PREF_FLAG_IS_USER_REGISTRED = "pref_flag_is_user_registered"

    val PREF_FLAG_IS_CONS_SAVED = "pref_flag_is_cons_saved"
    val PREF_FLAG_IS_TOKEN_UPDATED = "pref_flag_is_token_updated"
    val PREF_FLAG_IS_GUJ_SUPPORTED = "pref_flag_is_guj_supported"


    val PREF_USER_CONS_ID = "pref_user_cons_id"
    val PREF_USER_DIST_ID = "pref_user_dist_id"
    val PREF_USER_CONS_LAT = "pref_user_cons_lat"
    val PREF_USER_CONS_LNG = "pref_user_cons_lng"


    val PREF_LAST_AD_SHOW_TIME = "pref_last_ad_show_time"
    val PREF_AD_DISPLAY_CONT = "pref_ad_display_cont"
    val PREF_AD_REPEAT_TIME: Long = 3 * 60 * 1000L;
//    val PREF_AD_REPEAT_TIME: Long = 1 * 20 * 1000L;


    val PREF_FCM_TOKEN = "pref_fcm_token"
    val EXTRA_INFO_URL = "url"
    val EXTRA_NEWS_DATE = "date"
    val EXTRA_NEWS_POSITION = "pos"
    val EXTRA_PARTY_ID = "party_id"

    val KEY_POLLING_CENTER_LIST = "polling_center_list"
    val KEY_POLLING_CENTER_SELECTED_POS = "polling_center_selected_pos"

    val YOUTUBE_PLAYER_DEVELOPER_KEY = "AIzaSyDhdrw0xGHb53gXIX2a70b0wBqv97m4hU8"
    val VIDEO_URL = "video_url"

    val EXTRA_CANDIDATE_PARTY_ID = "cand_party_id"
    val EXTRA_PARTY_NAME = "party_name"
    val EXTRA_YEAR = "extra_year"
    val EXTRA_CANDIDATE_NAME = "cand_name"
    val EXTRA_PARTY_DETAIL_CANDIDATE_ID = "cand_id"
    val EXTRA__CANDIDATE_PARTY_ID = "id"

    val REQUEST_CODE_BUILD_ALERT = 20
    val FROM_NAVIGATION = "from_navigation"
    val PDF_URL = "pdf_url"

}