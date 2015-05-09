package closure.space.collabtodo.models;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.util.List;

import closure.space.collabtodo.helper.JsonFactory;

/**
 * Created by praveen on 8/5/15.
 */
public class TodoList extends SugarRecord<TodoList> {

    @SerializedName("listid")
    String listid;

    @SerializedName("listname")
    String listname;

    @SerializedName("entries")
    List<Entry> entries;

    /**
     * Get global unique id of this list
     *
     * @return id
     */
    public String getListid() {
        return listid;
    }

    /**
     * Set a global unique id of this list
     *
     * @param listid
     */
    public void setListid(String listid) {
        this.listid = listid;
    }

    /**
     * Get user readable list name
     *
     * @return
     */
    public String getListname() {

        JsonFactory.toObject("", Entry.class);
        return listname;
    }

    /**
     * Set a user readable list name
     *
     * @param listname
     */
    public void setListname(String listname) {
        this.listname = listname;
    }

    /**
     * Get list of entries in this todolist
     *
     * @return
     */
    public List<Entry> getEntries() {
        return entries;
    }

    /**
     * Set list of entries in this todolist
     *
     * @param entries
     */
    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}
