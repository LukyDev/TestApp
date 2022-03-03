package com.lukdev.test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GiphyTrending {

    @SerializedName("data")
    @Expose
    public List<Datum> data = null;
    @SerializedName("pagination")
    @Expose
    public Pagination pagination;
    @SerializedName("meta")
    @Expose
    public Meta meta;

    public List<Datum> getData() {
        return data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public Meta getMeta() {
        return meta;
    }

    public class Datum {

        @SerializedName("type")
        @Expose
        public String type;
        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("url")
        @Expose
        public String url;
        @SerializedName("slug")
        @Expose
        public String slug;
        @SerializedName("bitly_gif_url")
        @Expose
        public String bitlyGifUrl;
        @SerializedName("bitly_url")
        @Expose
        public String bitlyUrl;
        @SerializedName("embed_url")
        @Expose
        public String embedUrl;
        @SerializedName("username")
        @Expose
        public String username;
        @SerializedName("source")
        @Expose
        public String source;
        @SerializedName("title")
        @Expose
        public String title;
        @SerializedName("rating")
        @Expose
        public String rating;
        @SerializedName("content_url")
        @Expose
        public String contentUrl;
        @SerializedName("source_tld")
        @Expose
        public String sourceTld;
        @SerializedName("source_post_url")
        @Expose
        public String sourcePostUrl;
        @SerializedName("is_sticker")
        @Expose
        public Integer isSticker;
        @SerializedName("import_datetime")
        @Expose
        public String importDatetime;
        @SerializedName("trending_datetime")
        @Expose
        public String trendingDatetime;
        @SerializedName("images")
        @Expose
        public Images images;
        @SerializedName("user")
        @Expose
        public User user;


        public String getType() {
            return type;
        }

        public String getId() {
            return id;
        }

        public String getUrl() {
            return url;
        }

        public String getSlug() {
            return slug;
        }

        public String getBitlyGifUrl() {
            return bitlyGifUrl;
        }

        public String getBitlyUrl() {
            return bitlyUrl;
        }

        public String getEmbedUrl() {
            return embedUrl;
        }

        public String getUsername() {
            return username;
        }

        public String getSource() {
            return source;
        }

        public String getTitle() {
            return title;
        }

        public String getRating() {
            return rating;
        }

        public String getContentUrl() {
            return contentUrl;
        }

        public String getSourceTld() {
            return sourceTld;
        }

        public String getSourcePostUrl() {
            return sourcePostUrl;
        }

        public Integer getIsSticker() {
            return isSticker;
        }

        public String getImportDatetime() {
            return importDatetime;
        }

        public String getTrendingDatetime() {
            return trendingDatetime;
        }

        public Images getImages() {
            return images;
        }

        public User getUser() {
            return user;
        }
    }

    public class DownsizedSmall {

        @SerializedName("height")
        @Expose
        public String height;
        @SerializedName("width")
        @Expose
        public String width;
        @SerializedName("mp4_size")
        @Expose
        public String mp4Size;
        @SerializedName("mp4")
        @Expose
        public String mp4;

        public String getHeight() {
            return height;
        }

        public String getWidth() {
            return width;
        }

        public String getMp4Size() {
            return mp4Size;
        }

        public String getMp4() {
            return mp4;
        }
    }

    public class FixedHeight {

        @SerializedName("height")
        @Expose
        public String height;
        @SerializedName("width")
        @Expose
        public String width;
        @SerializedName("size")
        @Expose
        public String size;
        @SerializedName("url")
        @Expose
        public String url;
        @SerializedName("mp4_size")
        @Expose
        public String mp4Size;
        @SerializedName("mp4")
        @Expose
        public String mp4;
        @SerializedName("webp_size")
        @Expose
        public String webpSize;
        @SerializedName("webp")
        @Expose
        public String webp;

        public String getHeight() {
            return height;
        }

        public String getWidth() {
            return width;
        }

        public String getSize() {
            return size;
        }

        public String getUrl() {
            return url;
        }

        public String getMp4Size() {
            return mp4Size;
        }

        public String getMp4() {
            return mp4;
        }

        public String getWebpSize() {
            return webpSize;
        }

        public String getWebp() {
            return webp;
        }
    }

    public class FixedHeightSmallStill {

        @SerializedName("height")
        @Expose
        public String height;
        @SerializedName("width")
        @Expose
        public String width;
        @SerializedName("size")
        @Expose
        public String size;
        @SerializedName("url")
        @Expose
        public String url;

        public String getHeight() {
            return height;
        }

        public String getWidth() {
            return width;
        }

        public String getSize() {
            return size;
        }

        public String getUrl() {
            return url;
        }
    }

    public class FixedWidth {

        @SerializedName("height")
        @Expose
        public String height;
        @SerializedName("width")
        @Expose
        public String width;
        @SerializedName("size")
        @Expose
        public String size;
        @SerializedName("url")
        @Expose
        public String url;
        @SerializedName("mp4_size")
        @Expose
        public String mp4Size;
        @SerializedName("mp4")
        @Expose
        public String mp4;
        @SerializedName("webp_size")
        @Expose
        public String webpSize;
        @SerializedName("webp")
        @Expose
        public String webp;

        public String getHeight() {
            return height;
        }

        public String getWidth() {
            return width;
        }

        public String getSize() {
            return size;
        }

        public String getUrl() {
            return url;
        }

        public String getMp4Size() {
            return mp4Size;
        }

        public String getMp4() {
            return mp4;
        }

        public String getWebpSize() {
            return webpSize;
        }

        public String getWebp() {
            return webp;
        }
    }

    public class FixedWidthSmall {

        @SerializedName("height")
        @Expose
        public String height;
        @SerializedName("width")
        @Expose
        public String width;
        @SerializedName("size")
        @Expose
        public String size;
        @SerializedName("url")
        @Expose
        public String url;
        @SerializedName("mp4_size")
        @Expose
        public String mp4Size;
        @SerializedName("mp4")
        @Expose
        public String mp4;
        @SerializedName("webp_size")
        @Expose
        public String webpSize;
        @SerializedName("webp")
        @Expose
        public String webp;

        public String getHeight() {
            return height;
        }

        public String getWidth() {
            return width;
        }

        public String getSize() {
            return size;
        }

        public String getUrl() {
            return url;
        }

        public String getMp4Size() {
            return mp4Size;
        }

        public String getMp4() {
            return mp4;
        }

        public String getWebpSize() {
            return webpSize;
        }

        public String getWebp() {
            return webp;
        }
    }

    public class Hd {

        @SerializedName("height")
        @Expose
        public String height;
        @SerializedName("width")
        @Expose
        public String width;
        @SerializedName("mp4_size")
        @Expose
        public String mp4Size;
        @SerializedName("mp4")
        @Expose
        public String mp4;

        public String getHeight() {
            return height;
        }

        public String getWidth() {
            return width;
        }

        public String getMp4Size() {
            return mp4Size;
        }

        public String getMp4() {
            return mp4;
        }
    }

    public class Images {

        @SerializedName("original")
        @Expose
        public Original original;
        @SerializedName("downsized_small")
        @Expose
        public DownsizedSmall downsizedSmall;
        @SerializedName("fixed_height")
        @Expose
        public FixedHeight fixedHeight;
        @SerializedName("fixed_height_small_still")
        @Expose
        public FixedHeightSmallStill fixedHeightSmallStill;
        @SerializedName("fixed_width")
        @Expose
        public FixedWidth fixedWidth;
        @SerializedName("fixed_width_small")
        @Expose
        public FixedWidthSmall fixedWidthSmall;
        @SerializedName("original_still")
        @Expose
        public OriginalStill originalStill;
        @SerializedName("preview_gif")
        @Expose
        public PreviewGif previewGif;
        @SerializedName("hd")
        @Expose
        public Hd hd;
        @SerializedName("480w_still")
        @Expose
        s480wStill s480Still;
        @SerializedName("4k")
        @Expose
        s4k s4kStill;

        public Original getOriginal() {
            return original;
        }

        public DownsizedSmall getDownsizedSmall() {
            return downsizedSmall;
        }

        public FixedHeight getFixedHeight() {
            return fixedHeight;
        }

        public FixedHeightSmallStill getFixedHeightSmallStill() {
            return fixedHeightSmallStill;
        }

        public FixedWidth getFixedWidth() {
            return fixedWidth;
        }

        public FixedWidthSmall getFixedWidthSmall() {
            return fixedWidthSmall;
        }

        public OriginalStill getOriginalStill() {
            return originalStill;
        }

        public PreviewGif getPreviewGif() {
            return previewGif;
        }

        public Hd getHd() {
            return hd;
        }

        public s480wStill getS480Still() {
            return s480Still;
        }

        public s4k getS4kStill() {
            return s4kStill;
        }
    }

    public class Meta {

        @SerializedName("status")
        @Expose
        public Integer status;
        @SerializedName("msg")
        @Expose
        public String msg;
        @SerializedName("response_id")
        @Expose
        public String responseId;

        public Integer getStatus() {
            return status;
        }

        public String getMsg() {
            return msg;
        }

        public String getResponseId() {
            return responseId;
        }
    }

    public class Original {

        @SerializedName("height")
        @Expose
        public String height;
        @SerializedName("width")
        @Expose
        public String width;
        @SerializedName("size")
        @Expose
        public String size;
        @SerializedName("url")
        @Expose
        public String url;
        @SerializedName("mp4_size")
        @Expose
        public String mp4Size;
        @SerializedName("mp4")
        @Expose
        public String mp4;
        @SerializedName("webp_size")
        @Expose
        public String webpSize;
        @SerializedName("webp")
        @Expose
        public String webp;
        @SerializedName("frames")
        @Expose
        public String frames;
        @SerializedName("hash")
        @Expose
        public String hash;

        public String getHeight() {
            return height;
        }

        public String getWidth() {
            return width;
        }

        public String getSize() {
            return size;
        }

        public String getUrl() {
            return url;
        }

        public String getMp4Size() {
            return mp4Size;
        }

        public String getMp4() {
            return mp4;
        }

        public String getWebpSize() {
            return webpSize;
        }

        public String getWebp() {
            return webp;
        }

        public String getFrames() {
            return frames;
        }

        public String getHash() {
            return hash;
        }
    }

    public class OriginalStill {

        @SerializedName("height")
        @Expose
        public String height;
        @SerializedName("width")
        @Expose
        public String width;
        @SerializedName("size")
        @Expose
        public String size;
        @SerializedName("url")
        @Expose
        public String url;

        public String getHeight() {
            return height;
        }

        public String getWidth() {
            return width;
        }

        public String getSize() {
            return size;
        }

        public String getUrl() {
            return url;
        }
    }

    public class Pagination {

        @SerializedName("total_count")
        @Expose
        public Integer totalCount;
        @SerializedName("count")
        @Expose
        public Integer count;
        @SerializedName("offset")
        @Expose
        public Integer offset;

        public Integer getTotalCount() {
            return totalCount;
        }

        public Integer getCount() {
            return count;
        }

        public Integer getOffset() {
            return offset;
        }
    }

    public class PreviewGif {

        @SerializedName("height")
        @Expose
        public String height;
        @SerializedName("width")
        @Expose
        public String width;
        @SerializedName("size")
        @Expose
        public String size;
        @SerializedName("url")
        @Expose
        public String url;

        public String getHeight() {
            return height;
        }

        public String getWidth() {
            return width;
        }

        public String getSize() {
            return size;
        }

        public String getUrl() {
            return url;
        }
    }

    public class User {

        @SerializedName("avatar_url")
        @Expose
        public String avatarUrl;
        @SerializedName("profile_url")
        @Expose
        public String profileUrl;
        @SerializedName("username")
        @Expose
        public String username;
        @SerializedName("display_name")
        @Expose
        public String displayName;
        @SerializedName("description")
        @Expose
        public String description;
        @SerializedName("instagram_url")
        @Expose
        public String instagramUrl;
        @SerializedName("website_url")
        @Expose
        public String websiteUrl;
        @SerializedName("is_verified")
        @Expose
        public Boolean isVerified;

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public String getProfileUrl() {
            return profileUrl;
        }

        public String getUsername() {
            return username;
        }

        public String getDisplayName() {
            return displayName;
        }

        public String getDescription() {
            return description;
        }

        public String getInstagramUrl() {
            return instagramUrl;
        }

        public String getWebsiteUrl() {
            return websiteUrl;
        }

        public Boolean getVerified() {
            return isVerified;
        }
    }

    public class s480wStill {

        @SerializedName("height")
        @Expose
        public String height;
        @SerializedName("width")
        @Expose
        public String width;
        @SerializedName("size")
        @Expose
        public String size;
        @SerializedName("url")
        @Expose
        public String url;

        public String getHeight() {
            return height;
        }

        public String getWidth() {
            return width;
        }

        public String getSize() {
            return size;
        }

        public String getUrl() {
            return url;
        }
    }

    public class s4k {

        @SerializedName("height")
        @Expose
        public String height;
        @SerializedName("width")
        @Expose
        public String width;
        @SerializedName("mp4_size")
        @Expose
        public String mp4Size;
        @SerializedName("mp4")
        @Expose
        public String mp4;

        public String getHeight() {
            return height;
        }

        public String getWidth() {
            return width;
        }

        public String getMp4Size() {
            return mp4Size;
        }

        public String getMp4() {
            return mp4;
        }
    }
}