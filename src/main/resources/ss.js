function e(e, t) {
    return e.find(function (e) {
        return !!e && e.ui_id == t;
    });
}

function t(e, t) {
    return e.ui_id === t;
}

function a(e, t) {
    var a = e(), r = a && a.main && a.main.currState, o = !1;
    return r || (o = t === n.STATE_NONE), (o = r === t) || console.error("state error,expect:" + t + ",but is:" + r),
        o;
}

Object.defineProperty(exports, "__esModule", {
    value: !0
}), exports.createPlusPlzazLikeCountAction = exports.createRecogAtlasListAction = exports.doChooseFileIfNeed = exports.uploadFile = exports.requestIden = exports.fetchMyRedpackData = exports.resetStateAction = exports.createFinishUploadAction = exports.createFetchedNewuserRedpackDataAction = exports.createUploadFileAction = exports.refreshFoldAction = exports.populateStateAction = exports.createRequestResetAction = exports.createIdentifiedAction = void 0;

var r = Object.assign || function (e) {
        for (var t = 1; t < arguments.length; t++) {
            var a = arguments[t];
            for (var r in a) Object.prototype.hasOwnProperty.call(a, r) && (e[r] = a[r]);
        }
        return e;
    }, o = require("../constants/actions.js"), n = require("../constants/states"), i = require("../utils/location"),
    s = require("../utils/wechat"), c = require("../utils/util"), l = (require("../utils/login"),
        require("../config/index")), u = require("../utils/session"), p = require("./aes"), d = require("./log"),
    g = (require("./profile"),
        require("../constants/commonCons")), A = function (e) {
        return console.log(">>>>>> createPopulateAction", e), {
            type: o.ACTION_POPULATE,
            payload: e
        };
    }, f = function (e) {
        return {
            type: o.ACTION_GET_POI_CARDS,
            payload: e
        };
    }, T = (exports.createIdentifiedAction = function () {
        return {
            type: o.ACTION_IDENTIFIED
        };
    }, exports.createRequestResetAction = function (e) {
        return {
            type: o.ACTION_REQUEST_RESET,
            payload: e
        };
    }, exports.populateStateAction = function (a) {
        return function (a, r) {
            c.time("PROCESS_DATA"), c.clearCacheRegDetailData();
            var o = r(), i = [];
            if (o && o.main && o.main.retData && o.main.currState !== n.STATE_NONE) {
                var s = o.main.retData, l = s && s.recog, u = (s && s.recogCate, o.config && o.config.appName || "识花君");
                if (l) {
                    for (var p = s.isFlower, d = 0; d < l.length; d++) !function (r) {
                        var n = {}, u = l[r], p = e(u, 101);
                        if (!p) return "continue";
                        0 === r && s.actBanner && (n.bannerInfo = s.actBanner.bannerInfo, n.bannerType = s.actBanner.type,
                            n.hasBanner = s.actBanner.hasBanner), n.img = p.sImageUrl || "../../images/img_unkown.png";
                        var d = p.vectMarkupPicUrls;
                        n.imgList = d, n.showImgList = d && d.length > 0, n.imgListSize = d && d.length || 0,
                            n.title = p.sTitle, n.subtitle = p.sSubTitle || "", n.index = r, n.canScroll = !0,
                            n.isUnknown = !1, n.showUnknowIcon = !0;
                        var g = e(u, 114), A = [], T = e(u, 26);
                        if (T) {
                            var I = [], m = null;
                            if (T.group_act && T.group_act.length && T.group_act.forEach(function (e) {
                                var t = [];
                                if (c.processUserActivityListData(e.act_arr, !1).forEach(function (e) {
                                    e.isDayActivity ? m = {
                                        sActivityName: e.sActivityName,
                                        sPoiName: e.sPoiName || T.sPoiName || "",
                                        sClickUrl: e.sClickUrl,
                                        sIcon: e.sIcon
                                    } : t.push(e);
                                }), t.length > 0) {
                                    var a = {};
                                    a.group_title = e.group_title, a.group_arr = t, I.push(a);
                                }
                            }), n.groupList = I, n.dayOrderList = m, !o.main.poiCards) {
                                if (T.winCardList && T.winCardList[0] && T.winCardList[0].imageUrl) {
                                    var _ = Object.assign({}, T.winCardList[0]),
                                        h = c.formatImgUrl(c.FORM_IMG_TYPE.card, _.imageUrl);
                                    _.imageUrl = h, T.winCardList[0] = _;
                                }
                                a(f(T.winCardList[0]));
                            }
                        }
                        var E = e(u, 136);
                        if (E && (n.cautionBlockDesc = {
                            ui_id: 136,
                            title: E.sTitle,
                            titleIcon: "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAAXNSR0IArs4c6QAABTZJREFUaAXtWU9sFGUUf9/sttumC61sS2nt7jawlhCqQWlIDFKgxhj1wAHCwUTRGIMkmngxQUVbTexBEuOBFEyUxKQHE+MBD4qGxOLJRPwTS6ElFFtqAbt/Sttt9+/M8802W7+Z+WZ2dmYTOOxc9r3f+/++f/PNAlSfageqHah24F52gFU6OA4MSNEzZw8ywNcRIASADYAwKTE2HPD7PmfXr2cqGbOiBUS3bl0HCysXEHGXKEnG2CWogQMtMzO3RHInmOTESGSDkYgPFpbPmSWv2pCsB3JwrqArcuIAq1gBsWT2HUTYXyoHtQjSfbuUnl15RabQQkdHJJNnl6nFPluBGUvX1kB308zMpC19C6WKjAAlf8p28moyiHXZHJyyyMu2yPUIxDeFDsmofK2PKAU7wPfcswCKApnvvgfln1m9Cngkz6HA7elvDIIyAFcF4Pbt/lh84SrN/Q4+prdnJzR+NQyS31+AcXkZ7h5+HvK//c6rAWMw04wbtrF//1rWCMpgXE2hWHyxX5+8Gtv//rtryas8a2gAf/8JldQ8ZBuMsbv9GrBMxvEIJFqD3TLgH3RYefUxA9fGQFq/XgMrySTEI9s0mMowYDk65HYE7ty8YhDaAByPgMxgSJR8IaYsG0Pn80aMEASsUQCHhEIboKMCYptCR2g/32PmH1dSBhGm0wasCJCvvbG20AtFvpzfsguY7+xsUkD52CoIpowFgAjjnCgKnkxs3tzIQbbIsgvIp+VBGveNVt5xZcUgxpT5CKwqY2t+JfeRwbAEUFYB0bZgDx1CR0v4BFG3haOic8QQj0Xbw4/pYEvWdgHqazJ1/jQt3JI2zkZAXdDkW1FOF2JZpv2/sGQyRdX4mS+O0mLrKfJWv6JuizCRD4qxK/bZ2VdFMhFmq4Cl1i0b6dAZFDkQYaJdSDStRLYFDHFwsb2r2VTOCWwVkGLZk7RfN3F2lqSo2yLMzAmNwoa0krLc6Yq2JQuYawvuoYX7YtHAzq9wDVicAyKftKBfSrSHdotkPGZZAO7b56WVVfYpKeq2COMT0dO0oFleVoYKOeiFHG9ZQGx88k3qfjenb4sUjkCJg8zE8SOxick3TGQF2LSA+IORDpqL/VbGpjLRq4SzAug+gR9Eg8F2s1imBchy+lMyWn2hN7M2wcW7UKmTWOyMptI6+hDwiViqvs0Knnhb8GlZwfMCkS3I0/UQ1D7Zp9HNXvwZ5CtXNVg5jOSRnmq+dfOC3sZQgPrJI7qUuUznYkSvfC95ur1daw40PszGxrJ8HobLSCyZPk4KrpOXOjvpTvyMeoGH7PkfQL7xNx+3bJrcdEUTi2+RoeaFTzMC0XC4DTPKDQpaV3YEzqBm9+PQOPwlsPr6AoqZDCwceQVyIxc5LQckYynmk7a0TE/fLlprF3EGX3ObvOrY/+HAWvIqz3y+wj1ZpV09iPWQUY7xPrQFgNLLC53Sns6wwdQTNmIGJXvAXl5NVwCY7re8USk6N0p7gO7Jj4/rEMesZtprCkBgc47dcobJ4ydAiUbXEGV+HpLv9a/x7ghc4u01uxCV9iMCPMErOKFl6naitw9q+/YXbinZkRHAxLwTV0YbJn3Lg5rhWP2+vzxKW1bFJiwfzDXNYK6lzhtmU1Nrx7pmCrVMTNDweF6mb36Czwquw7tyQH+OzHs83gN88qpDTQEq0HJn+icmeR8l8heVvx8eSv5XD0JvYHbKkJNmCvHJ0psoi7WHdgLDHaAw27cx3odLGinxOY8kjT4wO/WnS19V82oHqh24XzvwHyhO29hEAdwQAAAAAElFTkSuQmCC",
                            vContents: E.vContents
                        }), g) {
                            var C = g && g.sDescText || "";
                            if (C) {
                                var y = [];
                                y.push({
                                    text: C
                                });
                                var v = [];
                                v.push({
                                    ui_id: 114,
                                    title: "识别说明",
                                    titleIcon: "../../images/recog_icon.png",
                                    shareIcon: "../../images/recog_share.png",
                                    textAndImg: y,
                                    isFold: C.length >= 108,
                                    showFoldText: C.length >= 108,
                                    type: 0
                                }), n.descBlockBaikeItem = v;
                            }
                        }
                        for (var S = 0; S < u.length; S++) {
                            var w = u[S];
                            if (w) if (t(w, 116)) !function () {
                                var e = [];
                                w.vectParagraph && w.vectParagraph.forEach(function (t) {
                                    e.push({
                                        subtitle: t.sTitle || "",
                                        text: t.sText,
                                        image: t.vectImage && t.vectImage[0] || ""
                                    });
                                }), A.push({
                                    ui_id: w.ui_id,
                                    title: w.stTitleInfo && w.stTitleInfo.sText,
                                    titleIcon: w.stTitleInfo && w.stTitleInfo.titleIcon || "../../images/recog_icon_default.png",
                                    shareIcon: "../../images/recog_share.png",
                                    textAndImg: e,
                                    align: "left",
                                    isFold: !1,
                                    showFoldText: !1,
                                    type: 0
                                });
                            }(); else if (t(w, 117) || t(w, 118)) !function () {
                                var e = [];
                                w.vectTableItem && w.vectTableItem.forEach(function (t) {
                                    e.push({
                                        titleIcon: t.sLeftIcon || "",
                                        subTitle: t.sLeftText,
                                        text: t.sRightText
                                    });
                                }), e && e.length && A.push({
                                    ui_id: w.ui_id,
                                    title: w.stTitleInfo && w.stTitleInfo.sText,
                                    titleIcon: w.stTitleInfo && w.stTitleInfo.titleIcon || "../../images/recog_icon_default.png",
                                    shareIcon: "../../images/recog_share.png",
                                    descItem: e,
                                    align: "left",
                                    isFold: !1,
                                    showFoldText: !1,
                                    type: 0
                                });
                            }(); else if (t(w, 107) && 0 === r) {
                                var D = "";
                                if (w.share_templist) for (var x = 0; x < w.share_templist.length; x++) if (w.share_templist[x] && w.share_templist[x].sBottomText) {
                                    D = w.share_templist[x].sBottomText;
                                    break;
                                }
                                var O = [];
                                O.push({
                                    ui_id: w.ui_id,
                                    title: w.stTitleInfo && w.stTitleInfo.sText,
                                    titleIcon: w.stTitleInfo && w.stTitleInfo.titleIcon || "../../images/recog_icon_default.png",
                                    shareIcon: "",
                                    isFold: !1,
                                    showFoldText: !1,
                                    type: 0,
                                    lunarDate: s.lunarDate,
                                    sBottomText: D
                                }), n.descBlockShareItem = O;
                            }
                        }
                        n.index = r, n.dataExpand = 0, n.isAllFold = 0;
                        var N = A;
                        0 === r && (n.dataExpand = 2, n.descBlockItem = A), c.cacheRegDetailData({
                            descBlockItem: N
                        }), i.push(n);
                    }(d);
                    if (p) {
                        var g = {};
                        g.title = "未知", g.subtitle = "没有我想要的结果", g.index = l.length, g.canScroll = !1, g.isUnknown = !0,
                            g.word = "", g.img = "../../images/img_unkown.png", g.showUnknowIcon = !0, g.tipsType = 1,
                            i.push(g);
                    } else {
                        var T = {}, I = s.extraData;
                        T.title = I && I.name || "未知", T.subtitle = "未识别到请重新识别", T.index = l.length, T.canScroll = !1,
                            T.isUnknown = !0, T.hasNoResult = I && !0, T.showFeedBack = "未知" !== T.title, T.showUnknowIcon = !0,
                            T.word = "", T.img = "../../images/img_no_flower.png", T.showTwoOptions = !0, T.tipsType = 2,
                            i.push(T);
                    }
                } else {
                    var m = {};
                    m.title = "暂时无法鉴定", m.subtitle = "Umm..." + u + "还得努力学习啊", m.index = 0, m.canScroll = !1,
                        m.hasNoResult = !0, m.isUnknown = !0, m.word = "", m.img = "../../images/img_noresult.png",
                        m.showUnknowIcon = !0, m.tipsType = 3, i.push(m);
                }
            } else {
                var _ = {};
                _.title = "识别失败", _.subtitle = "请打开网络或重试", _.index = 0, _.canScroll = !1, _.hasNoResult = !0,
                    _.isUnknown = !0, _.word = "", _.img = "../../images/img_noresult.png", _.tipsType = 4,
                    i.push(_);
            }
            c.timeEnd("PROCESS_DATA"), console.log(">>>>>> populateStateAction", i), a(A(i));
        };
    }, exports.refreshFoldAction = function () {
        return function (e, t) {
            var a = t(), r = a.main.retData.allItems, o = a.device.pixelRatio, n = wx.createSelectorQuery();
            r && r.forEach(function (e, t) {
                e && e.descBlockItem && e.descBlockItem.forEach(function (e, a) {
                    n.select("#block-" + t + "-" + a).boundingClientRect();
                });
            }), setTimeout(function () {
                n.exec(function (t) {
                    t && t.forEach(function (e) {
                        if (e) {
                            var t = e.id.split("-"), a = t[1], n = t[2];
                            r[a] && r[a].descBlockItem && r[a].descBlockItem[n] && (r[a].descBlockItem[n].isFold = e.height * o > 400,
                                r[a].descBlockItem[n].showFoldText = e.height * o > 400);
                        }
                    }), c.time("TIMER_refresh_all"), e(T(r));
                });
            }, 500);
        };
    }, function (e) {
        return {
            type: o.ACTION_REFRESH_ALLITEMS,
            payload: e
        };
    }), I = function () {
        return {
            type: o.ACTION_CHOOSE_IMG
        };
    }, m = exports.createUploadFileAction = function (e) {
        return wx.reportAnalytics && wx.reportAnalytics("event_recog_upload", {}), {
            type: o.ACTION_START_UPLOAD,
            payload: e
        };
    }, _ = function (e) {
        return new getApp().WeToast().toast({
            title: e
        }), console.log("createFailedAction : ", e), wx.hideLoading && wx.hideLoading(),
        wx.reportAnalytics && wx.reportAnalytics("event_recog_result", {
            error: 1,
            reason: e,
            success: 0,
            plant: ""
        }), {
            type: o.ACTION_FAILED,
            payload: e
        };
    }, h = (exports.createFetchedNewuserRedpackDataAction = function (e) {
        return {
            type: o.ACTION_FETCHED_NEWUSER_REDPACK_DATA,
            payload: e
        };
    }, exports.createFinishUploadAction = function (e) {
        return e && e.recog ? wx.reportAnalytics && wx.reportAnalytics("event_recog_result", {
            error: 0,
            reason: "",
            success: 1,
            plant: ""
        }) : wx.reportAnalytics && wx.reportAnalytics("event_recog_result", {
            error: 0,
            reason: "",
            success: 0,
            plant: ""
        }), {
            type: o.ACTION_FINISH_UPLOAD,
            payload: e
        };
    }), E = (exports.resetStateAction = function () {
        return {
            type: o.ACTION_RESET
        };
    }, function (e) {
        return {
            type: o.ACTION_REQUEST_IDEN,
            payload: e
        };
    }), C = function (e) {
        return {
            type: o.ACTION_FETCHED_MY_REDPACK,
            payload: e
        };
    }, y = (exports.fetchMyRedpackData = function () {
        return function (e, t) {
            t(), s.request({
                url: c.getCurrentAllPath(l.userRedpackData),
                data: {
                    session: JSON.stringify(u.get())
                },
                method: "GET"
            }).then(function (t) {
                if (t && t.data && t.data.data) {
                    var a = t.data.data;
                    e(C(a));
                }
            }, function (e) {
            });
        };
    }, exports.requestIden = function (e, t, a, r) {
        return function (o, n) {
            var i = n();
            i.main && i.main.requestIdening ? new getApp().WeToast().toast({
                title: "正在请求"
            }) : (o(E(!0)), s.request({
                url: c.getCurrentAllPath(l.reqiden),
                data: {
                    session: JSON.stringify(u.get()),
                    picId: e,
                    extraData: JSON.stringify(a),
                    isFlower: t ? 1 : 0
                }
            }).then(function (e) {
                o(E(!1)), e.data && 200 === e.statusCode && e.data.data ? r && r() : new getApp().WeToast().toast({
                    title: "请求失败"
                });
            }, function () {
                o(E(!1)), new getApp().WeToast().toast({
                    title: "请求失败"
                });
            }));
        };
    }, exports.uploadFile = function (e, t) {
        return function (a, r) {
            (0, i.getLocation)(a).then(function (o) {
                var n = null;
                return o && (n = {
                    latitude: o.latitude,
                    longitude: o.longitude
                }), S(e, a, r, n, t);
            });
        };
    }), v = function () {
        var e = "shihuajun_" + Date.now(), t = p.enc.Utf8.parse("1e38666d8037899b"),
            a = p.enc.Utf8.parse("picpicpicpicpicp"), r = p.algo.AES.createEncryptor(t, {
                iv: a
            }), o = "";
        return o += r.process(e), o += r.finalize();
    }, S = function (e, t, r, o, i) {
        var l = {
            ch: r().ch || "0"
        }, p = JSON.stringify(l), g = e, A = JSON.stringify(u.get()), f = {
            url: "https://pic.sogou.com/risapi/wap/recognizepic",
            filePath: g,
            name: "image",
            formData: {
                sign: v(),
                session: A,
                channel: "shihuajun",
                category: "flower",
                uuid: u.get("uuid"),
                qbid: u.get("qbid"),
                fromType: i,
                recogParam: p
            },
            complete: function () {
            }
        }, T = Date.now();
        getApp().report && getApp().report.captureCustomEvent("upload_file"), c.time("UPLOAD_REG"),
            s.uploadFile(f).then(function (e) {
                if (c.timeEnd("UPLOAD_REG"), d.info(e.statusCode + "|" + Boolean(e.data)), e && 200 === e.statusCode && e.data) {
                    if (console.log("uploadFile ret : ", "success"), !a(r, n.STATE_UPLOADING)) return t(_("state error"));
                    var o = null;
                    try {
                        o = JSON.parse(e.data);
                    } catch (e) {
                    }
                    if (d.info(e.statusCode + "|" + o.status + "|" + o.info + "|" + u.get("qbid") + "|" + (o.data && o.data.picUrl) + "|" + JSON.stringify(o.data && o.data.recognition || "")),
                    o && !o.err && o.data && 0 === o.status) {
                        var i = o.data, s = i.recognition.length > 0 ? [[{
                            ui_id: 101,
                            sImageUrl: i.recognition && i.recognition[0] && i.recognition[0].baikeImage || i.picUrl || "",
                            sTitle: i.recognition && i.recognition[0] && i.recognition[0].content || "",
                            vectMarkupPicUrls: []
                        }, {
                            ui_id: 114,
                            sDescText: i.recognition && i.recognition[0] && i.recognition[0].summary || ""
                        }]] : [];
                        (i.recognition && i.recognition[0] && i.recognition[0].attributeList || [] || []).forEach(function (e) {
                            s[0].push({
                                ui_id: 116,
                                isFold: !1,
                                stTitleInfo: {
                                    sText: e.k
                                },
                                vectParagraph: [{
                                    sText: e.v
                                }]
                            });
                        });
                        var l = {
                            recog: s,
                            recogCate: [],
                            redpackData: o.data.newRedpackData,
                            actPushData: o.data.actPushData,
                            event: {
                                url: i.picUrl
                            },
                            models: o.data.models,
                            isFlower: o.data.recognition && o.data.recognition[0] && o.data.recognition[0].key && "flower" === o.data.recognition[0].key || !1,
                            categoryId: o.data.categoryId,
                            extraData: o.data.extraData,
                            sKey: o.data.sKey || "",
                            timestamp: o.data.timestamp,
                            actBanner: o.data.actBanner,
                            plazaSkuData: o.data.plazaSkuData || [],
                            descBlockQbItem: o.data.descBlockQbItem || null,
                            lunarDate: o.data.lunarDate || "",
                            sku: o.data.sku || ""
                        };
                        console.log(">>>> retData", l), o.data.newRedpackData && (l.redpackData = o.data.newRedpackData),
                        l.actBanner && l.actBanner.hasBanner && c.reportEvent("result_banner"), getApp().report && getApp().report.captureCustomEvent("choose_image_rst", {
                            err: "success"
                        });
                        var p = Date.now() - T;
                        getApp().report && getApp().report.captureCustomEvent("recog_duration", {
                            duration: p
                        }), c.time("PASS_REG_RESULT"), t(h(l));
                    } else console.log("uploadFile ret error : ", o.err), t(h({
                        recog: null,
                        recogCate: null,
                        event: null,
                        models: null
                    }));
                } else getApp().report && getApp().report.captureCustomEvent("choose_image_rst", {
                    err: "net_status"
                }), t(h({
                    recog: null,
                    recogCate: null,
                    event: null,
                    models: null
                }));
            }, function (e) {
                if (getApp().report && getApp().report.captureCustomEvent("choose_image_rst", {
                    err: "upload_failed"
                }), console.log("upload file failed : ", e), e && e.errMsg && "uploadFile:fail Error: ESOCKETTIMEDOUT" === e.errMsg) {
                    var a = Date.now() - T;
                    getApp().report && getApp().report.captureCustomEvent("recog_timeout_duration", {
                        duration: a
                    });
                }
                t(_("上传失败"));
            });
    };

exports.doChooseFileIfNeed = function (e) {
    var t = (e = e || [g.IMAGE_TYPE_CAMERA]) === [g.IMAGE_TYPE_CAMERA] ? "camera" : "album", r = t;
    return function (o, i) {
        if (!a(i, n.STATE_NONE)) return o(_("state error"));
        console.log("doChooseFileIfNeed : ", t), o(I()), s.chooseImage({
            count: 1,
            sizeType: ["compressed"],
            sourceType: [t]
        }).then(function (t) {
            if (getApp().report && getApp().report.captureCustomEvent("choose_image_req", {
                type: e[0]
            }), t && t.tempFilePaths && t.tempFilePaths.length) {
                if (!a(i, n.STATE_CHOOSING_FILE)) return o(_("state error"));
                wx.getFileInfo({
                    filePath: t.tempFilePaths[0],
                    success: function (e) {
                        e && e.size && console.log("choose_picture img size === after: " + e.size);
                    }
                }), o(m(t.tempFilePaths[0])), y(t.tempFilePaths[0], e[0])(o, i);
            } else new getApp().WeToast().toast({
                title: r + "err1"
            }), getApp().report && getApp().report.captureCustomEvent("choose_image_rst", {
                err: "file_err"
            }), o(_("选择图片有误"));
        }, function (e) {
            new getApp().WeToast().toast({
                title: r + "err2"
            }), console.log("doChooseFileIfNeed error: %o", e), getApp().report && getApp().report.captureCustomEvent("choose_image_rst", {
                err: "cancel"
            }), o(_("取消选择图片"));
        });
    };
}, exports.createRecogAtlasListAction = function (e) {
    return {
        type: o.ACTION_CREATE_ATLAS_LIST_DATA,
        payload: e
    };
}, exports.createPlusPlzazLikeCountAction = function (e) {
    return {
        type: o.ACTION_CREATE_LIKE_ATLAS,
        payload: e
    };
};

exports.default = function (e, t) {
    switch (e = e || {
        currState: n.STATE_NONE,
        retData: null,
        reason: "",
        tempFilePath: "",
        requestIdening: !1,
        currIdenIndex: -1,
        poiCards: null,
        isIdentified: !1,
        requestReset: !1
    }, t.type) {
        case o.ACTION_REQUEST_IDEN:
            return r({}, e, {
                requestIdening: t.payload
            });

        case o.ACTION_CHOOSE_IMG:
            return r({}, e, {
                currState: n.STATE_CHOOSING_FILE
            });

        case o.ACTION_START_UPLOAD:
            return r({}, e, {
                currState: n.STATE_UPLOADING,
                tempFilePath: t.payload
            });

        case o.ACTION_REQUEST_RESET:
            return r({}, e, {
                requestReset: t.payload
            });

        case o.ACTION_FINISH_UPLOAD:
            return r({}, e, {
                retData: t.payload,
                currState: n.STATE_FINISHED
            });

        case o.ACTION_FETCHED_NEWUSER_REDPACK_DATA:
            return r({}, e, {
                redpackData: t.payload
            });

        case o.ACTION_FAILED:
            return r({}, e, {
                currState: n.STATE_NONE,
                reason: t.payload
            });

        case o.ACTION_RESET:
            return r({}, e, {
                tempFilePath: "",
                poiCards: null,
                requestReset: !1,
                currState: n.STATE_NONE,
                reason: "",
                retData: null,
                isIdentified: !1
            });

        case o.ACTION_POPULATE:
            var a = r({}, e.retData, {
                allItems: t.payload
            });
            return r({}, e, {
                retData: a
            });

        case o.ACTION_REFRESH_ALLITEMS:
            var i = r({}, e.retData, {
                allItems: t.payload
            });
            return r({}, e, {
                retData: i
            });

        case o.ACTION_IDENTIFIED:
            return r({}, e, {
                isIdentified: !0
            });

        case o.ACTION_GET_POI_CARDS:
            return r({}, e, {
                poiCards: t.payload
            });

        case o.ACTION_FETCHED_MY_REDPACK:
            return r({}, e, {
                myRedpackData: t.payload
            });

        case o.ACTION_CREATE_LIKE_ATLAS:
            return r({}, e, {
                retData: r({}, e.retData, {
                    plazaSkuData: t.payload
                })
            });
    }
    return e;
};