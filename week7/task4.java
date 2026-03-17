class BrowserHistory {

    List<String> history;
    int index;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        index = 0;
    }

    public void visit(String url) {
        while (history.size() > index + 1) {
            history.remove(history.size() - 1);
        }
        history.add(url);
        index++;
    }

    public String back(int steps) {
        index = Math.max(0, index - steps);
        return history.get(index);
    }

    public String forward(int steps) {
        index = Math.min(history.size() - 1, index + steps);
        return history.get(index);
    }
}
