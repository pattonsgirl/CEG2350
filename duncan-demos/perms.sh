#!/usr/bin/env bash
#
# perm_scenarios.sh — sets up two classic Linux permission scenarios for
# classroom demonstration. Does NOT test/demonstrate the results — that's
# left for the class to explore live.
#
# Must be run as root (sudo ./perm_scenarios.sh)
#
# Scenario 1: user has no perms on a folder, but their group does.
# Scenario 2: parent folder has no write bit, child folder does.

set -uo pipefail

BASE_DIR="/home/scen1"
TEST_USER="sally"
TEST_GROUP="website"

if [[ $EUID -ne 0 ]]; then
  echo "This script must be run as root (try: sudo $0)" >&2
  exit 1
fi

echo "=================================================="
echo " Setting up Permissions Test Scenarios in $BASE_DIR"
echo "=================================================="

# --- Clean slate ---
rm -rf "$BASE_DIR"
mkdir -p "$BASE_DIR"

# --- Create test group/user ---
if ! getent group "$TEST_GROUP" >/dev/null; then
  groupadd "$TEST_GROUP"
  echo "Created group: $TEST_GROUP"
fi

if ! id "$TEST_USER" >/dev/null 2>&1; then
  useradd -m -s /bin/bash "$TEST_USER"
  echo "Created user:  $TEST_USER"
fi

echo
echo "NOTE: '$TEST_USER' is intentionally NOT a member of '$TEST_GROUP'."
echo "      That's the setup for Scenario 1."

###############################################################################
# Scenario 1: group has access, the user (as owner/other) does not
###############################################################################
S1_DIR="$BASE_DIR/scenario1_group_access"
mkdir -p "$S1_DIR"
chown root:"$TEST_GROUP" "$S1_DIR"
chmod 070 "$S1_DIR"    # owner(root): ---, group: rwx, other: ---

echo
echo "--- Scenario 1: $S1_DIR ---"
ls -ld "$S1_DIR"
echo "Owner (root): none | Group ($TEST_GROUP): rwx | Other: none"
echo "Fix to explore in class:"
echo "  usermod -aG $TEST_GROUP $TEST_USER"

###############################################################################
# Scenario 2: parent has no write bit, child does
###############################################################################
S2_PARENT="$BASE_DIR/scen2_par"
S2_CHILD="$S2_PARENT/scen2_childdir"
mkdir -p "$S2_CHILD"
chown -R "$TEST_USER":"$TEST_USER" "$S2_PARENT"
chmod 555 "$S2_PARENT"   # r-xr-xr-x — no write anywhere, including owner
chmod 777 "$S2_CHILD"    # rwxrwxrwx — wide open

echo
echo "--- Scenario 2: $S2_PARENT  (child: $S2_CHILD) ---"
ls -ld "$S2_PARENT" "$S2_CHILD"
echo "Parent: r-x (no write, even for owner) | Child: rwx for everyone"

echo
echo "=================================================="
echo " Setup complete. Scenarios live under: $BASE_DIR"
echo "=================================================="
echo
echo "To tear everything down:"
echo "  sudo rm -rf $BASE_DIR && sudo userdel -r $TEST_USER && sudo groupdel $TEST_GROUP"
