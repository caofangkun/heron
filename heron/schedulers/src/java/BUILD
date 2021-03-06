package(default_visibility = ["//visibility:public"])

load("/tools/rules/heron_deps", "heron_java_proto_files")

common_deps_files = [
    "//heron/common/src/java:basics-java",
    "@commons_io_commons_io//jar",
    "@com_google_guava_guava//jar",
]

spi_deps_files = [
    "//heron/spi/src/java:common-spi-java",
    "//heron/spi/src/java:statemgr-spi-java",
    "//heron/spi/src/java:scheduler-spi-java",
    "//heron/spi/src/java:utils-spi-java",
]

api_deps_files = [
    "//heron/api/src/java:api-java",
]

scheduler_deps_files = \
    heron_java_proto_files() + \
    common_deps_files + \
    spi_deps_files + \
    api_deps_files

yarn_deps_files = \
    scheduler_deps_files + [
        "//heron/scheduler-core/src/java:scheduler-java",
        "//third_party/java:yarn",
    ]

java_library(
    name='local-scheduler-java',
    srcs = glob(["**/local/*.java"]),
    deps = scheduler_deps_files,
    resources = glob(["**/local/*.yaml"]),
)

java_binary(
    name='local-scheduler-unshaded',
    srcs = glob(["**/local/*.java"]),
    deps = scheduler_deps_files,
    resources = glob(["**/local/*.yaml"]),
)

genrule(
    name = "heron-local-scheduler",
    srcs = [":local-scheduler-unshaded_deploy.jar"],
    outs = ["heron-local-scheduler.jar"],
    cmd  = "cp $< $@",
)

java_library(
    name='aurora-scheduler-java',
    srcs = glob(["**/aurora/*.java"]),
    deps = scheduler_deps_files,
    resources = glob(["**/aurora/*.aurora"]),
)

java_binary(
    name='aurora-scheduler-unshaded',
    srcs = glob(["**/aurora/*.java"]),
    deps = scheduler_deps_files,
    resources = glob(["**/aurora/*.aurora"]),
)

genrule(
    name = "heron-aurora-scheduler",
    srcs = [":aurora-scheduler-unshaded_deploy.jar"],
    outs = ["heron-aurora-scheduler.jar"],
    cmd  = "cp $< $@",
)

java_library(
    name='null-scheduler-java',
    srcs = glob(
        ["**/NullLauncher.java"] +
        ["**/NullScheduler.java"]
    ),
    deps = scheduler_deps_files,
)

java_binary(
    name='null-scheduler-unshaded',
    srcs = glob(
        ["**/NullLauncher.java"] +
        ["**/NullScheduler.java"]
    ),
    deps = scheduler_deps_files,
)

genrule(
    name = "heron-null-scheduler",
    srcs = [":null-scheduler-unshaded_deploy.jar"],
    outs = ["heron-null-scheduler.jar"],
    cmd  = "cp $< $@",
)

java_library(
    name='slurm-scheduler-java',
    srcs = glob(["**/slurm/*.java"]),
    deps = scheduler_deps_files,
    resources = glob(["**/slurm/*.sh","**/slurm/*.yaml"]),
)

java_binary(
    name='slurm-scheduler-unshaded',
    srcs = glob(["**/slurm/*.java"]),
    deps = scheduler_deps_files,
    resources = glob(["**/slurm/*.sh","**/slurm/*.yaml"]),
)

genrule(
    name = "heron-slurm-scheduler",
    srcs = [":slurm-scheduler-unshaded_deploy.jar"],
    outs = ["heron-slurm-scheduler.jar"],
    cmd  = "cp $< $@",
)

java_library(
    name='yarn-scheduler-java',
    srcs = glob(["**/yarn/*.java"]),
    deps = yarn_deps_files,
    resources = glob(["**/yarn/*.yaml"]),
)

java_binary(
    name='yarn-scheduler-unshaded',
    srcs = glob(["**/yarn/*.java"]),
    deps = yarn_deps_files,
    resources = glob(["**/yarn/*.yaml"]),
)

genrule(
    name = "heron-yarn-scheduler",
    srcs = [":yarn-scheduler-unshaded_deploy.jar"],
    outs = ["heron-yarn-scheduler.jar"],
    cmd  = "cp $< $@",
)
