
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(nullable = true, name = "id")
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "x")
    private Double x;
    @Column(nullable = false, name = "y")
    private Double y;
    @Column(nullable = false, name = "r")
    private Double r;
    @Column(nullable = false, name = "result")
    private boolean result;
    @Column(nullable = false, name = "time")
    private String time;
}
