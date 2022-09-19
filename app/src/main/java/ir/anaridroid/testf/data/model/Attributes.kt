package ir.anaridroid.testf.data.model

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("HD")
    val HD: Boolean,
    @SerializedName("age_range")
    val age_range: String,
    @SerializedName("audio")
    val audio: Audio,
    @SerializedName("avg_rate_label")
    val avg_rate_label: String,
    @SerializedName("badge")
    val badge: Badge,

    @SerializedName("categories")
    val categories: List<Category>,

    @SerializedName("commingsoon_txt")
    val commingsoon_txt: String,

    @SerializedName("countries")
    val countries: List<Country>,

    @SerializedName("cover")
    val cover: Any,

    @SerializedName("descr")
    val descr: String,

    @SerializedName("director")
    val director: Any,

    @SerializedName("dubbed")
    val dubbed: Dubbed,

    @SerializedName("duration")
    val duration: Any,

    @SerializedName("freemium")
    val freemium: Boolean,

    @SerializedName("imdb_rate")
    val imdb_rate: String,

    @SerializedName("language_info")
    val language_info: LanguageInfo,

    @SerializedName("last_watch")
    val last_watch: List<Any>,

    @SerializedName("link_key")
    val link_key: String,

    @SerializedName("link_type")
    val link_type: String,

    @SerializedName("movie_id")
    val movie_id: String,

    @SerializedName("movie_title")
    val movie_title: String,

    @SerializedName("movie_title_en")
    val movie_title_en: String,

    @SerializedName("output_type")
    val output_type: String,

    @SerializedName("pic")
    val pic: Pic,

    @SerializedName("position")
    val position: Int,

    @SerializedName("pro_year")
    val pro_year: String,

    @SerializedName("publish_date")
    val publish_date: String,

    @SerializedName("rate_avrage")
    val rate_avrage: String,

    @SerializedName("rate_enable")
    val rate_enable: Boolean,

    @SerializedName("rel_data")
    val rel_data: RelData,

    @SerializedName("serial")
    val serial: Serial,

    @SerializedName("sid")
    val sid: Int,

    @SerializedName("subtitle")
    val subtitle: Subtitle,

    @SerializedName("tag_id")
    val tag_id: Any,

    @SerializedName("theme")
    val theme: String,

    @SerializedName("uid")
    val uid: String,

    @SerializedName("uuid")
    val uuid: String,

    @SerializedName("watch_list_action")
    val watch_list_action: String,

    @SerializedName("watermark")
    val watermark: Boolean
)