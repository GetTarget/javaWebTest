package dhl.db.pojo;

public class Goods {
    private String goodsid;
    private String goodsname;
    private int goodscount;
    private float goodsprice;

    public Goods(String goodsid, String goodsname, int goodscount, float goodsprice) {
        this.goodsid = goodsid;
        this.goodsname = goodsname;
        this.goodscount = goodscount;
        this.goodsprice = goodsprice;
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public int getGoodscount() {
        return goodscount;
    }

    public void setGoodscount(int goodscount) {
        this.goodscount = goodscount;
    }

    public float getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(float goodsprice) {
        this.goodsprice = goodsprice;
    }

    @Override
    public String toString() {
        return "goodDao{" +
                "goodsid='" + goodsid + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", goodscount=" + goodscount +
                ", goodsprice=" + goodsprice +
                '}';
    }
}
