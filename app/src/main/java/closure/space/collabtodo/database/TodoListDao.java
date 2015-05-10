package closure.space.collabtodo.database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import closure.space.collabtodo.models.Entry;
import closure.space.collabtodo.models.TodoList;

/**
 * TodoList Data Access Object
 * <p/>
 * This abstracts the details of reading or updating TodoList entries in / out of the Sugar Database
 * <p/>
 * Created by praveen on 8/5/15.
 */
public class TodoListDao {

    /**
     * Saves / updates the current todolist in local database.
     * Creates a new todolist if doesn't exist already.
     *
     * @param list TodoList
     */
    public static void save(TodoList list) {
        list.save();

        // Set listids for each entry
        for (Entry entry : list.getEntries()) {
            entry.setListid(list.getListid());
            EntryDao.save(entry);
        }
    }


    /**
     * Deletes the TodoList and all it's entries from the local database.
     *
     * @param list TodoList
     */
    public static void delete(TodoList list) {
        TodoList.deleteAll(TodoList.class, "listid = ?", list.getListid());

        for (Entry entry : list.getEntries())
            EntryDao.delete(entry);
    }

    /**
     * Deletes the TodoList and all it's entries from the local database.
     *
     * @param listid TodoList id
     */
    public static void delete(String listid) {
        List<TodoList> lists = TodoList.find(TodoList.class, "listid = ?", listid);
        if (lists == null || lists.size() == 0)
            return;
        delete(lists.get(0));
    }

    /**
     * Get a list of all TodoLists in the local database
     *
     * @return List of TodoList
     */
    public static List<TodoList> list() {
        List<TodoList> mTodoLists = TodoList.listAll(TodoList.class);
        for (TodoList list : mTodoLists)
            list.setEntries(EntryDao.getEntries(list.getListid()));
        return mTodoLists;
    }

}
