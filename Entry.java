class Entry<E> {
        final String key;
        Object value;
        Entry<E> next;
        int index;

        Entry(String k, E v) {
            key = k;
            value = v;
        }

        @SuppressWarnings("unchecked")
        public E getValue() {
          E e = (E) value;
            return e;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public String getKey() {
            return key;
        }

    }
